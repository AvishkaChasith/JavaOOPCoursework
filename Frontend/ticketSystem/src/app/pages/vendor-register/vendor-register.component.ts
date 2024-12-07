import { Component, inject, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { VendorService } from '../../services/vendor.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

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

  constructor(private vendorService: VendorService) {}

  onSubmit() {
    this.vendorService
      .vendorRegister(this.vendorRegisterObj)
      .subscribe((response: any) => {
        this.responseMessage = response.message;
        // this.router.navigate(['/vendor-login']);
      });
  }
}
