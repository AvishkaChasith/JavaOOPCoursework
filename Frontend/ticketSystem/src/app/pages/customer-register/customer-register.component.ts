import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-register',
  standalone: true,
  imports: [],
  templateUrl: './customer-register.component.html',
  styleUrl: './customer-register.component.css'
})
export class CustomerRegisterComponent {

  customerObj:any={
    customerName:'',
    customerLastName:'',
    customerEmail:'',
    customerPassword:''
  };

  responseMessage:string='';


  constructor(private customerService: CustomerService) { }

  onSubmit(){
    this.customerService.createCustomer(this.customerObj).subscribe({
      next:(response)=>{
        this.responseMessage=response;
      }
    })
  }
}
