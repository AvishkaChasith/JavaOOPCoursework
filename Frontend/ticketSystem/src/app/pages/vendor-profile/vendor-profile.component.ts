import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { VendorService } from '../../services/vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendor-profile',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './vendor-profile.component.html',
  styleUrl: './vendor-profile.component.css',
})
export class VendorProfileComponent {
  ticketAdd: any = {
    vendorId:'12345',
    totalTickets: '',
    thicketsPerRelease: '',
    vendorRetrievalInterval: '',
  };
  responseMessage: string = '';
  isSubmitting: boolean = false;

  constructor(private vendorService: VendorService, private router: Router) {}

  onSubmit() {
    if (this.isSubmitting) return;
    this.isSubmitting = true;
    this.vendorService.addTicket(this.ticketAdd).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        if (response.message === 'Ticket adding successfully') {
          this.router.navigate(['home']);
        }
      },
      (error) => {
        this.responseMessage = error.error.message || 'An error occured';
        this.isSubmitting = false;
      }
    );
  }
}
