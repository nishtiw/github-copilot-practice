import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CheckinService {
  private apiUrl = 'http://localhost:8080/flightreservation/reservations'; // Replace with your API URL

  reservationData: any;

  constructor(private http: HttpClient) { }

  fetchReservation(id: number): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get(url);
  }

  updateReservation(id: number, reservation: any): Observable<any> {
    const url = `${this.apiUrl}/`;
    return this.http.post(url, reservation);
  }
}