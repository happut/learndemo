package com.github.happut.learndemospringboot.webdav;

import org.apache.jackrabbit.webdav.client.methods.HttpMkcol;

public class TestWebDAV {
    public static void main(String[] args) {


        HttpMkcol mkCol = new HttpMkcol("http://192.168.1.71:4502/crx/repository/crx.default/content/dam/testfolder");


    }
}
