package com.zlrx.am.writerservice.repository;

import com.zlrx.am.writerservice.domain.Writer;
import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<Writer, Long> {
}
