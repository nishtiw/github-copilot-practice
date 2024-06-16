import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CheckinService } from 'src/app/services/checkin.service';

@Component({
  selector: 'app-startcheckin',
  templateUrl: './startcheckin.component.html',
  styleUrls: ['./startcheckin.component.css']
})
export class StartcheckinComponent implements OnInit {

  reservationId: number = 0;

  constructor(private service:CheckinService, private router:Router) { }
  
  ngOnInit(): void {
    
  }

  onClick() {
    this.service.fetchReservation(this.reservationId).subscribe(
      data => {
        console.log(data);
        this.service.reservationData = data;
        this.router.navigate(['/checkin']);
      }
    )
  }

}

