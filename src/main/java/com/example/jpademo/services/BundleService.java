package com.example.jpademo.services;

import com.example.jpademo.repositories.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    @Autowired
    BundleRepository bundleRepository;
}
