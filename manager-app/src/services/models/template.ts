import { TemplateResponse } from '@http/dtos/template-response'

export class Template {
  id: string
  name: string
  domain: string
  createdAt: Date

  constructor(response: TemplateResponse) {
    this.id = response.id
    this.name = response.name
    this.domain = response.domain
    this.createdAt = new Date()
  }
}
