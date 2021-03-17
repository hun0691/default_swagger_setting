package com.domain.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domain.model.Lotto;
import com.domain.repository.LottoRepository;

@Component
public class DBWriter implements ItemWriter<Lotto> {

	@Autowired
	private LottoRepository lottoRepository;
	
	@Override
	public void write(List <? extends Lotto> lotto ) {
	
		lottoRepository.saveAll(lotto);
	}
}
