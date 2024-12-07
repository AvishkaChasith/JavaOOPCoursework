import { Component } from '@angular/core';
import { VendorService } from '../../services/vendor.service';

@Component({
  selector: 'app-vendor-login',
  standalone: true,
  imports: [],
  templateUrl: './vendor-login.component.html',
  styleUrl: './vendor-login.component.css'
})
export class VendorLoginComponent {
  vendor:any={
    vendorEmail:'',
    vendorPassword:''
  }
  responseMessage: string='';

  constructor(private vendorService: VendorService){}

  onSubmit(){
    this.vendorService.vendorRegister(this.vendor).subscribe({
      next:(response)=>{
        this.responseMessage=response;
      }
    })
  }

}
