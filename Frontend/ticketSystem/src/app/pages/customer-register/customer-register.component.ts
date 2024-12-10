import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-register',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './customer-register.component.html',
  styleUrl: './customer-register.component.css',
})
export class CustomerRegisterComponent {

  
  customerObj: any = {
    customerName: '',
    customerLastName: '',
    customerEmail: '',
    customerPassword: '',
  };

  responseMessage: string = '';
  isSubmitting: boolean = false;

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {}

  onSubmit() {
    if (this.isSubmitting) return;
    this.isSubmitting = true;
    this.customerService.createCustomer(this.customerObj).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        if (response.message === 'customer registered successfully') {
          this.router.navigate(['home']);
        }
      },
      (error) => {
        this.responseMessage =
          error.error.message || 'Registration failed. Please try again later.';
        this.isSubmitting = false;
      }
    );
  }
}
