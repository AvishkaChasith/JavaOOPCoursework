import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { VendorRegisterComponent } from './pages/vendor-register/vendor-register.component';
import { CommonModule} from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, VendorRegisterComponent, CommonModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ticketSystem';
}
