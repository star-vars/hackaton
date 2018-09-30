import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatTabsModule} from '@angular/material/tabs';

import {AppComponent} from './app.component';
import {ThemeComponent} from './theme/theme.component';
import {ThemeListComponent} from './theme/theme-list/theme-list.component';
import {ThemeEditComponent} from './theme/theme-edit/theme-edit.component';
import {TaskComponent} from './task/task.component';
import {TaskEditComponent} from './task/task-edit/task-edit.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {UserProfileListComponent} from './user-profile/user-profile-list/user-profile-list.component';
import {routingModule} from "./routing.module";
import {LoginComponent} from "./login/login.component";
import {UserButtonComponent} from "./user-profile/user-button/user-button.component";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    ThemeComponent,  ThemeListComponent, ThemeEditComponent,
    TaskEditComponent,    TaskComponent,
    UserProfileComponent,   UserProfileListComponent, UserButtonComponent,
    LoginComponent


  ],
  imports: [
    BrowserModule, routingModule, FormsModule, HttpClientModule, BrowserAnimationsModule, MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
