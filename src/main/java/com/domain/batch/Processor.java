package com.domain.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.domain.model.Lotto;

@Component
public class Processor implements ItemProcessor<Lotto, Lotto> {

	@Override
	public Lotto process(Lotto item) throws Exception {
		// TODO Auto-generated method stub
		item.setRound(item.getRound());
		return item;
	}


}
