import { Page } from '@services/pagination/page'

import { TemplatesApi } from '@http/templates'
import { EmailTemplateInfo } from '@services/models/email-template-info'

export const findAll = async (pageNumber?: number, pageSize?: number) => {
  const { data: page } = await TemplatesApi.findAll(pageNumber, pageSize)
  return Page.of(page, (template) => new EmailTemplateInfo(template))
}

export const preview = (id: string, body: object) => {
  return TemplatesApi.preview(id, body)
}

export const TemplateService = {
  findAll,
  preview,
}
