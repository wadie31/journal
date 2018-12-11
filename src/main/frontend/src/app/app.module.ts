import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MatButtonModule, MatCardModule, MatInputModule, MatSnackBarModule, MatToolbarModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpModule } from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SharedModule,DialogModule ,GrowlModule,AccordionModule} from 'primeng/primeng';
import { AppComponent } from './app.component';
import { InfiniteScrollModule, InfiniteScroll } from 'angular2-infinite-scroll';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';
import { SynchroService } from './synchro.service';
import { AuthGuard } from './auth.guard';

const myRoots: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent  , canActivate: [AuthGuard] },
  { path: 'article', component: RegistrationComponent  , canActivate: [AuthGuard] }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    
    NavComponent,
    RegistrationComponent,
    LoginComponent,
  ],
  imports: [Ng4LoadingSpinnerModule.forRoot(),InfiniteScrollModule, 
    HttpClientModule,SharedModule,DialogModule ,GrowlModule,AccordionModule,
    HttpModule,BrowserModule, BrowserAnimationsModule, FormsModule, ReactiveFormsModule,
    MatButtonModule, MatCardModule, MatInputModule, MatSnackBarModule, MatToolbarModule,
    RouterModule.forRoot(myRoots,{useHash: true})
  ],
  exports:[RouterModule],
  providers: [SynchroService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
