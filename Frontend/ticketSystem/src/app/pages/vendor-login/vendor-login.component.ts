import { Component } from '@angular/core';
import { VendorService } from '../../services/vendor.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vendor-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './vendor-login.component.html',
  styleUrl: './vendor-login.component.css',
})
export class VendorLoginComponent {
  vendor: any = {
    vendorEmail: '',
    vendorPassword: '',
  };
  responseMessage: string = '';
  isSubmitting: boolean = false;

  constructor(private vendorService: VendorService, private router: Router) {}

  onSubmit() {
    if (this.isSubmitting) return;
    this.isSubmitting = true;
    this.vendorService.vendorLogin(this.vendor).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        if (response.message === 'Vendor logging in successfully') {
          this.router.navigate(['home']);
        }
      },
      (error) => {
        this.responseMessage =
          error.error.message || 'Login failed. Please try again.';
        this.isSubmitting = false;
      }
    );
  }
}
