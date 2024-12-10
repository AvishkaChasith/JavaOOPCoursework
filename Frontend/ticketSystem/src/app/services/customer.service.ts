import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = 'http://127.0.0.1:8080/customers'

  constructor(private http: HttpClient) { }


  createCustomer(customerObj:any): Observable<any>{
    return this.http.post<any>(this.apiUrl+'/customerRegister',customerObj);
  }

  loginCustomer(customer:any): Observable<any>{
    return this.http.post<any>(this.apiUrl+'/customerLogin',customer)
  }
}
