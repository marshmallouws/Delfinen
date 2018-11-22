INSERT INTO team (team_name) VALUES ('senior');
INSERT INTO team (team_name) VALUES ('junior');
#Members
#Senior
INSERT INTO member(ssn, firstname, lastname, birthyear, address, zipcode, phone, memberstatus, last_payment, team_id) 
	VALUES('1506952222', 'Oline', 'Sørensen', 1995, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 1),
		  ('1211941233', 'Åge', 'Olsen', 1994, 'Mosebakken 53', '2670', '91562665', 'active', 2016, 1),
		  ('0303951111', 'Henrik', 'Henningsen', 1995, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 1),
		  ('1804955455', 'Mogens', 'Hansen', 1995, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 1),
		  ('3003919090', 'Lisbeth', 'Knudsen', 1991, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 1),
		  ('1506921120', 'Mie', 'Moser', 1992, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 1),
          ('1507053333', 'Frede', 'Hansen', 2005, 'Lergravsvej 16', '2300', '44556677', 'active', 2017, 2),
          ('2202014547', 'Søren', 'Andersen', 2001, 'Nørregade', '2150', '91562665', 'active', 2017, 2),
          ('0412038089', 'Peter', 'Jakobsen', 2003, 'Spragelsevej 6', '2635', '92919293', 'active', 2017, 2),
          ('1506952588', 'Annika', 'Ehlers', 2002, 'Sømoseparken 80', '2750', '92919293', 'active', 2017, 2),
          ('0809021121', 'Hans', 'Hansen', 2002, 'Mosebakken 53', '2670', '91562665', 'active', 2017, 2),
          ('1111079930', 'Naja', 'Hansen', 2007, 'Mosevej 53', '2670', '91562665', 'active', 2017, NULL);

#Training Results
#1506952222 Oline Sørensen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-11-13' , '00:02:30', 1),
           ('Crawl', '2018-11-13' , '00:01:55', 1),
           ('Butterfly', '2018-11-13' , '00:04:30', 1),
           ('BACKCRAWL', '2018-11-13' , '00:02:30', 1),
           ('BACKCRAWL', '2018-10-13' , '00:02:50', 1);
    
#1211941233 Åge Olsen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-11-13' , '00:02:31', 2),
           ('Crawl', '2018-11-13' , '00:01:49', 2),
           ('Butterfly', '2018-11-13' , '00:04:36', 2),
           ('BACKCRAWL', '2018-11-13' , '00:02:21', 2),
           ('BACKCRAWL', '2018-10-13' , '00:02:20', 2);

#0303951111 Henrik Henningsen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-11-13' , '00:02:11', 3),
           ('Crawl', '2018-11-13' , '00:05:15', 3),
           ('BREASTSTROKE', '2018-11-13' , '00:04:36', 3),
           ('BREASTSTROKE', '2018-11-13' , '00:02:21', 3),
           ('BACKCRAWL', '2018-10-13' , '00:05:50', 3),
           ('BACKCRAWL', '2018-10-13' , '00:02:30', 3);

#1804955455 Mogens Hansen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-11-13' , '00:7:31', 4),
           ('Crawl', '2018-11-13' , '00:6:49', 4);
    
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('BREASTSTROKE', '2018-11-13' , '00:6:36', 4),
           ('BREASTSTROKE', '2018-11-13' , '00:6:21', 4),
		   ('BACKCRAWL', '2018-10-13' , '00:03:50', 4),
           ('BACKCRAWL', '2018-10-13' , '00:03:30', 4);

#3003919090 Lisbeth Knudsen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-11-13' , '00:7:31', 5),
		   ('Crawl', '2018-11-13' , '00:1:48', 5);
    
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('BREASTSTROKE', '2018-11-13' , '00:4:36', 5),
           ('BREASTSTROKE', '2018-11-13' , '00:1:21', 5),
           ('BACKCRAWL', '2018-10-13' , '00:10:50', 5),
           ('BACKCRAWL', '2018-10-13' , '00:09:30', 5);
    
#1506921120 Mie Moser
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2018-10-13' , '00:2:51', 6),
           ('BACKCRAWL', '2018-10-13' , '00:09:30', 6);
    
#Training Result Junior
#1507053333 Frede Hansen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2017-11-10', '00:01:55', 7),
           ('Crawl', '2017-11-10', '00:02:55', 7),
           ('Butterfly', '2017-11-10', '00:01:55', 7);
    
#2202014547 Søren Andersen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2017-11-10', '00:01:55', 8),
           ('Crawl', '2017-11-10', '00:02:55', 8),
           ('Backcrawl', '2017-11-10', '00:01:55', 8);

#0412038089 Peter Jakobsen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2017-11-10', '00:02:55', 9),
		   ('Crawl', '2017-11-10', '00:02:55', 9),
		   ('Backcrawl', '2017-11-10', '00:01:44', 9);

#1506952588 Annika Ehlers
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2017-11-10', '00:02:55', 10),
		   ('Crawl', '2017-11-10', '00:02:22', 10),
           ('Backcrawl', '2017-11-10', '00:01:00', 10);
    
#0809021121 Hans Hansen
INSERT INTO training_result (discipline, sw_date, sw_time, member_id)
	VALUES ('Crawl', '2017-11-10', '00:05:01', 11),
		   ('Crawl', '2017-11-10', '00:02:58', 11),
		   ('Backcrawl', '2017-11-10', '00:01:43', 11);

#Competition 
#1507053333 Frede Hansen
INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)
	VALUES ('Holbæk svømmehal', 'Crawl', 10, '00:02:01', 7);

#2202014547 Søren Andersen
INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)
	VALUES ('Holbæk svømmehal', 'Crawl', 10, '00:03:01', 8);
    
#0412038089 Peter Jakobsen
INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)
	VALUES ('Holbæk svømmehal', 'Crawl', 10, '00:05:01', 9),
		   ('Holbæk svømmehal', 'Crawl', 10, '00:05:02', 9);
    
#1506952588 Annika Ehlers
INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)
	VALUES ('Holbæk svømmehal', 'Crawl', 10, '00:04:01', 10);
    
#0809021121 Hans Hansen
INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)
	VALUES ('Holbæk svømmehal', 'Crawl', 10, '00:01:50', 11);