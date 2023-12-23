import { useEffect, useState } from 'react'

import {
  Card,
  CardBody,
  CardFooter,
  CardHeader,
} from '@material-tailwind/react'

import { EmailTemplateInfo } from '@services/models/email-template-info'
import { TemplateService } from '@services/templates'

import { Body } from '@components/body/Body'

import { TemplatesFooter } from './components/templates-footer/TemplatesFooter'
import { TemplatesHeader } from './components/templates-header/TemplatesHeader'
import { TemplatesTable } from './components/templates-table/TemplatesTable'
import { Pagination } from '@services/pagination/pagination'

export const Templates = () => {
  const [templates, setTemplates] = useState<EmailTemplateInfo[]>([])
  const [{ page: pageNumber, size: pageSize }, setPagination] =
    useState<Pagination>({
      page: 0,
      size: 0,
      totalPages: 0,
      totalElements: 0,
    })

  const fetchTemplates = async (page?: number, size?: number) => {
    try {
      const { content, ...pagination } = await TemplateService.findAll(
        page,
        size,
      )
      setTemplates(content)
      setPagination(pagination)
    } catch (error) {
      console.error(error)
    }
  }

  useEffect(() => {
    fetchTemplates(0, 5)
  }, [])

  return (
    <Body title="Templates">
      <Card className="h-full w-full">
        <CardHeader floated={false} shadow={false} className="rounded-none">
          <TemplatesHeader />
        </CardHeader>
        <CardBody className="px-0">
          <TemplatesTable templates={templates} />
        </CardBody>
        <CardFooter className="flex items-center justify-between border-t border-blue-gray-50 p-4">
          <TemplatesFooter page={pageNumber + 1} size={pageSize} />
        </CardFooter>
      </Card>
    </Body>
  )
}
