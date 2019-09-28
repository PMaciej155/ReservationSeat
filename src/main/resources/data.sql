INSERT INTO MOVIE (id, lenght, title)
VALUES 
(1, 90, 'Black Death') ,
(2, 95, 'White Death') ,
(3, 120, 'Black Life') , 
(4, 80, 'White Life') ;

INSERT INTO ROOM (id) VALUES
(1),
(2),
(3);

INSERT INTO SEAT (id, is_taken, row_of_seat, number_of_seat)
VALUES 
(1  ,false,  1, 1),
(2  ,false,  1, 2),
(3  ,false,  1, 3),
(4  ,false,  1, 3),
(5  ,false,  1, 4),
(6  ,false,  1, 5),
(7  ,false,  2, 1),
(8  ,false,  2, 2),
(9  ,false,  2, 3),
(10 ,false,  2, 3),
(11 ,false,  2, 4),
(12 ,false,  2, 5),
(13 ,false,  1, 1),
(14 ,false,  1, 2),
(15 ,false,  1, 3),
(16 ,false,  1, 3),
(17 ,false,  1, 4),
(18 ,false,  1, 5),
(19 ,false,  2, 1),
(20 ,false,  2, 2),
(21 ,false,  2, 3),
(22 ,false,  2, 3),
(23 ,false,  2, 4),
(24 ,false,  2, 5),
(25 ,false,  1, 1),
(26 ,false,  1, 2),
(27 ,false,  1, 3),
(28 ,false,  1, 3),
(29 ,false,  1, 4),
(30 ,false,  1, 5),
(31 ,false,  2, 1),
(32 ,false,  2, 2),
(33 ,false,  2, 3),
(34 ,false,  2, 3),
(35 ,false,  2, 4),
(36 ,false,  2, 5);

INSERT INTO ROOM_SEATS (room_id,seats_id ) VALUES
(1, 1 ),
(1, 2 ),
(1, 3 ),
(1, 4 ),
(1, 5 ),
(1, 6 ),
(1, 7 ),
(1, 8 ),
(1, 9 ),
(1, 10),
(1, 11),
(1, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16),
(2, 17),
(2, 18),
(2, 19),
(2, 20),
(2, 21),
(2, 22),
(2, 23),
(2, 24),
(3, 25),
(3, 26),
(3, 27),
(3, 28),
(3, 29),
(3, 30),
(3, 31),
(3, 32),
(3, 33),
(3, 34),
(3, 35),
(3, 36);

INSERT INTO SCREENING (day_of_screening,time_of_screening, movie_id, room_id ) VALUES
(TO_DATE('1/10/2019', 'DD/MM/YYYY'), TO_DATE('18:30', 'HH24:Mi'), 1,1),
(TO_DATE('2/10/2019', 'DD/MM/YYYY'), TO_DATE('20:00', 'HH24:Mi'), 2,1),
(TO_DATE('2/10/2019', 'DD/MM/YYYY'), TO_DATE('17:50', 'HH24:Mi'), 2,2),
(TO_DATE('1/10/2019', 'DD/MM/YYYY'), TO_DATE('20:00', 'HH24:Mi'), 3,2),
(TO_DATE('1/10/2019', 'DD/MM/YYYY'), TO_DATE('21:00', 'HH24:Mi'), 4,3),
(TO_DATE('1/10/2019', 'DD/MM/YYYY'), TO_DATE('18:00', 'HH24:Mi'), 2,3);



