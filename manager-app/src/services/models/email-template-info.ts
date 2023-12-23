import { EmailTemplateInformationResponse as EmailTemplateInfoResponse } from '@http/dtos/email-template-info-response'

export class EmailTemplateInfo {
  id: string
  name: string
  domain: string
  content?: string
  createdAt: Date

  constructor(response: EmailTemplateInfoResponse) {
    this.id = response.id
    this.name = response.name
    this.domain = response.domain
    this.content = undefined
    this.createdAt = new Date()
  }
}
