select source_id from transfer group by source_id,transfer_time having sum(amount)>1000 and transfer_time > '2019-01-01';