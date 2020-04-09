package com.yamhto.singleFramework.spring.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author yamhto
 * @className: TestResource.java
 * @package com.yamhto.singleFramework.spring.resource
 * @description:
 * @date 2020/4/7 15:34
 */
public class TestResource {

    public static void main(String[] args) throws IOException {
        Resource resource = new FileSystemResource("C:\\Users\\admin_YM\\Desktop\\poc");

        System.out.println(resource.getFile().getName());
        System.out.println(resource.getFile().getAbsolutePath());
        System.out.println(resource.getFile().getPath());
        File[] files = resource.getFile().listFiles();

        Arrays.asList(files).stream().forEach(file -> System.out.println(file.getName()));
    }
}
