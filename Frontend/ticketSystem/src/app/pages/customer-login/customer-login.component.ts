import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './customer-login.component.html',
  styleUrl: './customer-login.component.css',
})
export class CustomerLoginComponent {
  customer: any = {
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
    this.customerService.loginCustomer(this.customer).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        if (response.message === 'customer logged in successfully') {
          this.router.navigate(['home']);
        } // console.log(data);
      },
      (error) => {
        this.responseMessage =
          error.error.message || 'Login failed. Please try again.';
        this.isSubmitting = false;
      }
    );
  }
}
