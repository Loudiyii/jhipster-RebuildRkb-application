import { Component } from '@angular/core';
import { ProjectgeneratorService } from './projectgenerator.service';
import { NgClass, NgStyle } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'jhi-projectgenerator',
  standalone: true,
  imports: [NgStyle, FormsModule, NgClass],
  templateUrl: './projectgenerator.component.html',
  styleUrl: './projectgenerator.component.scss',
})
export class ProjectgeneratorComponent {
  applicationType: string = 'monolith';
  baseName: string = 'Defaultprojectname'; // Variable to store the entered baseName
  isGenerationSuccessful = false;
  isLoading = false;
  packageName: string = 'com.rbuildtest.app';
  serverPort: string = '8080';
  authenticationType: string = 'jwt';
  databaseType: string = 'sql';
  clientFramework: string = '';
  packageFolder: string = 'Rkube/rbuild/abdo';
  constructor(private projectgeneratorService: ProjectgeneratorService) {}

  generateProject(): void {
    this.isGenerationSuccessful = false;
    this.isLoading = true;

    // Check if baseName is entered before making the request
    if (
      !this.baseName ||
      !this.packageName ||
      !this.serverPort ||
      !this.authenticationType ||
      !this.authenticationType ||
      !this.databaseType ||
      !this.applicationType
    ) {
      console.error('All fields are required.');
      this.isLoading = false;
      return;
    }
    const payload = {
      baseName: this.baseName,
      packageName: this.packageName,
      serverPort: this.serverPort,
      authenticationType: this.authenticationType,
      databaseType: this.databaseType,
      applicationType: this.applicationType,
      clientFramework: this.clientFramework,
      packageFolder: this.packageFolder,
    };
    // Use this.baseName in the request body
    this.projectgeneratorService
      .generateProject(payload)
      .subscribe(
        (response: any) => {
          const blob = new Blob([response], { type: 'application/zip' });
          const link = document.createElement('a');
          link.href = window.URL.createObjectURL(blob);
          link.download = `${this.baseName}.zip`;
          link.click();
          this.isGenerationSuccessful = true;
        },
        (error: any) => {
          console.error('Error generating project', error);
        },
      )
      .add(() => {
        this.isLoading = false;
      });
  }
  setClientFramework(framework: string): void {
    this.clientFramework = framework;
  }
}
