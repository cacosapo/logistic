

CREATE TABLE `lane` (
  `LANE_ID` varchar(255) NOT NULL,
  `DEST` varchar(10) NOT NULL,
  `SOURCE` varchar(10) NOT NULL,
  `WEIGHT` int(11) NOT NULL,
  PRIMARY KEY (`LANE_ID`),
  UNIQUE KEY `LANE_ID` (`LANE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into lane values ('AB', 'B', 'A', 10);
insert into lane values ('BD', 'D', 'B', 15);
insert into lane values ('AC', 'C', 'A', 20);
insert into lane values ('CD', 'D', 'C', 30);
insert into lane values ('BE', 'E', 'B', 50);
insert into lane values ('DE', 'E', 'D', 30);

commit;