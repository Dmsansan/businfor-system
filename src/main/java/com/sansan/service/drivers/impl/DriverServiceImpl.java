package com.sansan.service.drivers.impl;

import com.sansan.bean.Drivers;
import com.sansan.mapper.DriverMapper;
import com.sansan.service.drivers.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DriverService")
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;
    @Override
    public List<Drivers> getDriverList() {
        return driverMapper.getDriverList();
    }
}
