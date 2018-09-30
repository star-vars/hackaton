import { RouterModule, Routes } from "@angular/router";
import { ModuleWithProviders } from "@angular/core";
import { ThemeListComponent } from "./theme/theme-list/theme-list.component";
import { TaskComponent } from "./task/task.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { UserProfileListComponent } from "./user-profile/user-profile-list/user-profile-list.component";
import { LoginComponent } from "./login/login.component";
import {StartedProjectComponent} from "./started-project/started.project.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "", component: ThemeListComponent },
  { path: "task/:id", component: TaskComponent },
  { path: "started/:id", component: StartedProjectComponent },
  { path: "user/:id", component: UserProfileComponent },
  { path: "users", component: UserProfileListComponent }
];

export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
