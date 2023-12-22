import { api } from '@http/api'
import { PageResponse } from '@http/dtos/page-response'
import { TemplateResponse } from '@http/dtos/template-response'

const RESOURCE_URL = 'templates'

export const findAll = async (page?: number, size?: number) => {
  const params = new URLSearchParams()

  if (page !== undefined) {
    params.append('page', page.toString())
  }

  if (size !== undefined) {
    params.append('size', size.toString())
  }

  return api.get<PageResponse<TemplateResponse>>(RESOURCE_URL, { params })
}

export const preview = (id: string, body: object) => {
  const uri = `${RESOURCE_URL}/preview/${id}`
  return api.post<string>(uri, body)
}

export const TemplatesApi = { findAll, preview }
