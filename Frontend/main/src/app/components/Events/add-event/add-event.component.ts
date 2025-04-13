import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss'],
})
export class AddEventComponent {
  eventForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private fb: FormBuilder) {
    this.eventForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      rayonAutorise: ['', Validators.required],
      latitude: ['', Validators.required],
      longitude: ['', Validators.required],
      // image: [null] // Optionnel si tu veux ajouter un champ image
    });
  }

  onSubmit(): void {
    if (this.eventForm.valid) {
      console.log(this.eventForm.value);
      this.successMessage = 'Event created successfully!';
      this.errorMessage = '';
      this.eventForm.reset();
    } else {
      this.errorMessage = 'Please fill in all required fields.';
      this.successMessage = '';
    }
  }

  onCancel(): void {
    this.eventForm.reset();
    this.successMessage = '';
    this.errorMessage = '';
  }

  onImageChange(input: any): void {
    const file = input.files[0];
    if (file) {
      // Tu peux utiliser FileReader si besoin d’un aperçu
      console.log('Selected image:', file);
    }
  }

  getCurrentLocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.eventForm.patchValue({
          latitude: position.coords.latitude,
          longitude: position.coords.longitude
        });
      }, (error) => {
        this.errorMessage = 'Unable to retrieve location.';
      });
    } else {
      this.errorMessage = 'Geolocation is not supported by this browser.';
    }
  }
}
