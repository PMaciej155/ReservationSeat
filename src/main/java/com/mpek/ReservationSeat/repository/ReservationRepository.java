package com.mpek.ReservationSeat.repository;

import com.mpek.ReservationSeat.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.screening  IN (SELECT screening FROM Screening screening WHERE screening.id = :screeningId)")
    List<Reservation> findByScreening(@Param("screeningId") Long screeningId);


}
