package com.zlrx.am.writerservice.service;

import com.zlrx.am.writerservice.domain.Writer;
import com.zlrx.am.writerservice.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public Iterable<Writer> fetchWriters() {
        return writerRepository.findAll();
    }

}
