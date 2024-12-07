import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorService {
  private apiUrl: string = 'http://127.0.0.1:8080/vendors/';

  constructor(private http: HttpClient) { }

    vendorRegister(vendor:any):  Observable<any> {
      return this.http.post<any>(this.apiUrl + "vendorRegister",vendor)
    }
  
  
}
