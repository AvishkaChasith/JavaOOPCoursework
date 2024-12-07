import { Routes } from '@angular/router';
import { VendorLoginComponent } from './pages/vendor-login/vendor-login.component';
import { VendorRegisterComponent } from './pages/vendor-register/vendor-register.component';
import { HomeComponent } from './pages/home/home.component';
import { CustomerRegisterComponent } from './pages/customer-register/customer-register.component';
import { CustomerLoginComponent } from './pages/customer-login/customer-login.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path: 'vendorLogin',
        component:VendorLoginComponent
    },
    {
        path:'vendorRegister',
        component:VendorRegisterComponent
    },
    {
        path:'home',
        component:HomeComponent
    },
    {
        path:'customerRegister',
        component:CustomerRegisterComponent
    },
    {
        path:'customerLogin',
        component:CustomerLoginComponent
    }
];
