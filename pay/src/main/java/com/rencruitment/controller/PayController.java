package com.rencruitment.controller;

import com.alipay.api.AlipayApiException;
import com.recruitment.domain.Order;
import com.rencruitment.config.AlipayConfig;
import com.rencruitment.service.OrderService;
import com.rencruitment.untils.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author 张浩
 * Date 2019/11/18
 */
@RestController
public class PayController {
    @Autowired
    private AlipayUtils alipayUtils;
    @Autowired
    private OrderService orderService;


    private static Order order = null;
    @RequestMapping("/pay")
    public String pay(@RequestBody Order order){
        this.order=getOrder(order);

        System.out.println(order);
//        System.out.println(order);
//        System.out.println(getOrder());

        String pay="";
        try {

            pay = alipayUtils.pay(order);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        orderService.save(order);
        return pay;
    }

    public Order getOrder(Order order){
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("00");
        String no = new SimpleDateFormat("yyyyMMddHHmm")
                .format(new Date()) + df.format(random.nextInt(100));
//        System.out.println(no);
        order.setOrderNumber(no);
//        System.out.println(order);
        return order;
    }

    @RequestMapping(value = "/notify" ,method = RequestMethod.POST)
    public void Verify(HttpServletRequest request, HttpServletResponse response)throws AlipayApiException{
        Map<String,String> params=new HashMap<String, String>();
        Map requestParams=request.getParameterMap();
        for(Iterator iter =requestParams.keySet().iterator();iter.hasNext();){
            String name=(String) iter.next();
            String[] values=(String[]) requestParams.get(name);
            String valueStr="";
            for (int i=0;i<values.length;i++){
                valueStr=(i==values.length-1)? valueStr+values[i]:valueStr+values[i]+",";
            }
            params.put(name,valueStr);
        }
//        System.out.println("==========>"+params);

        Order order=orderService.findByOrderCode(params.get("out_trade_no"));
        System.out.println(order);

//        if(null==null){
//            throw new AlipayApiException("抛出异常");
//        }

        if(order==null){
            throw new AlipayApiException("订单不存在");
        }

        BigDecimal total_amount=new BigDecimal(params.get("total_amount"));
        BigDecimal totalP=new BigDecimal(order.getMoney().toString());

//        System.out.println(totalP.compareTo(total_amount));

        if(totalP.compareTo(total_amount)!=0){
            throw new AlipayApiException("支付金额不正确");
        }

        if(!params.get("app_id").equals(AlipayConfig.app_id)){
            throw new AlipayApiException("支付地址不正确");
        }

        order.setOrderStatus(2);
        Date date = new Date();
        order.setPayTime(date);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String str="20110823";
//        Date dt=sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
//        rightNow.add(Calendar.YEAR,-1);//日期减1年
        rightNow.add(Calendar.MONTH,1);//日期加1个月
//        rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
        Date dt=rightNow.getTime();
//        String resdate = sdf.format(dt);
        System.out.println(sdf.format(dt));
        order.setExpireTime(dt);
        orderService.saveAndFlush(order);

        System.out.println("支付成功!");
    }

//    @RequestMapping("/pay_callback")k
//    public List<Order> getOrderList(@RequestBody Order order){
//
//        Order order1=payRepository.findByOrderCode(order.getOrderCode());
//
//        if(order1!=null){
//            order1.setOrderStatus("已支付");
//        }
//
//        payRepository.saveAndFlush(order1);
//
//        List<Order> list=payRepository.findByUserId(order.getUserId());
//
//        return list;
//
//    }
//
//    @RequestMapping("/p")
//    public void getOrder( ){
//        System.out.println("pppp");
//
//    }
}
