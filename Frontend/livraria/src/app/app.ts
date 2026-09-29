import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [ReactiveFormsModule, RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('livraria');
  private readonly http = inject(HttpClient);
  private readonly formBuilder = inject(FormBuilder);

  protected readonly apiUrl = 'http://localhost:8080/api/livros';
  protected readonly livroForm = this.formBuilder.nonNullable.group({
    titulo: ['', [Validators.required, Validators.maxLength(160)]],
    autor: ['', [Validators.required, Validators.maxLength(120)]],
    genero: ['', [Validators.required, Validators.maxLength(80)]],
    sinopse: ['', [Validators.required, Validators.maxLength(1000)]],
    anoPublicacao: [null as number | null, [Validators.required, Validators.min(1)]],
    quantidadePaginas: [null as number | null, [Validators.required, Validators.min(1)]],
  });

  protected isSubmitting = false;
  protected feedback = '';
  protected feedbackType: 'success' | 'error' | '' = '';

  protected cadastrarLivro(): void {
    if (this.livroForm.invalid || this.isSubmitting) {
      this.livroForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    this.feedback = '';
    this.feedbackType = '';

    this.http.post(this.apiUrl, this.livroForm.getRawValue()).subscribe({
      next: () => {
        this.livroForm.reset();
        this.feedback = 'Livro cadastrado com sucesso.';
        this.feedbackType = 'success';
        this.isSubmitting = false;
      },
      error: (error: HttpErrorResponse) => {
        this.feedback = error.status === 0
          ? 'Nao foi possivel conectar ao backend. Verifique se ele esta rodando em localhost:8080.'
          : 'Nao foi possivel cadastrar o livro. Confira os dados e tente novamente.';
        this.feedbackType = 'error';
        this.isSubmitting = false;
      },
    });
  }
}
