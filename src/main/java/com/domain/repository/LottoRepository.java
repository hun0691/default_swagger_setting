package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.Lotto;

public interface LottoRepository extends JpaRepository<Lotto , Integer> {

}
