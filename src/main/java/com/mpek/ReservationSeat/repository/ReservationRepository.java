package com.mpek.ReservationSeat.repository;

import com.mpek.ReservationSeat.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
