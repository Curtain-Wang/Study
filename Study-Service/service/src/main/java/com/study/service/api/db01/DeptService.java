package com.study.service.api.db01;

import org.springframework.web.multipart.MultipartFile;

public interface DeptService {

    void export(String url);

    void upload(MultipartFile file);
}
