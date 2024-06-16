import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CheckinService } from 'src/app/services/checkin.service';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {

  noOfBags: number = 0;
  data: any;

  constructor(private service: CheckinService, private router: Router) { }

  ngOnInit(): void {
    this.data = this.service.reservationData;
  }

  checkIn() {
    let request = {
      id: this.data.id,
      checkedIn: true,
      numberOfBags: this.noOfBags
    }

    this.service.updateReservation(this.data.reservationId, request).subscribe(data => {
      console.log(data);
      this.router.navigate(['/confirm']);
    });
  }

}
