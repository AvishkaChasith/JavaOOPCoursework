import { Component, inject, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { VendorService } from '../../services/vendor.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendor-register',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './vendor-register.component.html',
  styleUrl: './vendor-register.component.css',
})
export class VendorRegisterComponent {
  vendorRegisterObj: any = {
    vendorName: '',
    vendorLastName: '',
    vendorEmail: '',
    vendorPhone: '',
    vendorPassword: '',
  };

  responseMessage: string = '';
  isSubmitting: boolean = false;

  constructor(private vendorService: VendorService, private router: Router) {}

  onSubmit() {
    if (this.isSubmitting) return;
    this.isSubmitting = true;
    this.vendorService.vendorRegister(this.vendorRegisterObj).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        if (response.message === 'Vendor registered successfully') {
          this.router.navigate(['home']);
        }
      },
      (error) => {
        this.responseMessage =
          error.error.message || 'Registration failed. Please try again later';
        this.isSubmitting = false;
      }
    );
  }
}
