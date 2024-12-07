import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-login',
  standalone: true,
  imports: [],
  templateUrl: './customer-login.component.html',
  styleUrl: './customer-login.component.css'
})
export class CustomerLoginComponent {
  
  customer:any={
    customerEmail:'',
    customerPassword:''
  }
  responseMessage:string='';
  constructor(private customerService:CustomerService) { }

  onSubmit(){
    this.customerService.loginCustomer(this.customer).subscribe({
      next:(response)=>{
        this.responseMessage=response;
        // console.log(data);
      }});
  }
}

