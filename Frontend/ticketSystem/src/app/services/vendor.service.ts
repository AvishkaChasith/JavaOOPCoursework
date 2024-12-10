import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorService {
  private apiUrl: string = 'http://127.0.0.1:8080/vendors/';
  private addTicketUrl: string = 'http://127.0.0.1:8080/vendors/vendorLogin/addTicket';

  constructor(private http: HttpClient) { }

    vendorRegister(vendorRegisterObj:any):  Observable<any> {
      return this.http.post<any>(this.apiUrl + "vendorRegister",vendorRegisterObj)
    }
    vendorLogin(vendor:any): Observable<any>{
      return this.http.post<any>(this.apiUrl+"vendorLogin",vendor)
    }
    addTicket(ticketAdd:any): Observable<any>{
      return this.http.post<any>(this.addTicketUrl,ticketAdd)
    }
}
