package com.recruitment.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:44
 */
@RestController
@RequestMapping("/fdfs")
public class FdfsController {

	@Autowired
	private FastFileStorageClient fileStorageClient;

	@PostMapping("/upload")
	@ResponseBody
	public StorePath upload(@RequestParam MultipartFile file) throws IOException {
		StorePath storePath = fileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
		String picpath="http://114.215.147.154/"+storePath.getGroup()+"/"+storePath.getPath();
		System.out.println("图片的访问路径:"+picpath);
		return storePath;
	}
}
