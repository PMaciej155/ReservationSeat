package com.mpek.ReservationSeat.repository;

import com.mpek.ReservationSeat.model.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {

}
