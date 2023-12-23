import {
  ChevronUpDownIcon,
  PencilIcon,
  TrashIcon,
} from '@heroicons/react/24/outline'

import {
  IconButton,
  Input,
  Tooltip,
  Typography,
} from '@material-tailwind/react'

import { EmailTemplateInfo } from '@services/models/template'
import classNames from 'classnames'

import { ClipboardText } from 'phosphor-react'

const TABLE_HEAD = ['Nome', 'Domínio', 'ID', 'Data da ultima atualização']

interface TemplateTableProps {
  templates: EmailTemplateInfo[]
}

export const TemplatesTable = ({ templates }: TemplateTableProps) => {
  return (
    <table className="mt-4 w-full min-w-max table-auto text-left">
      <thead>
        <tr>
          {TABLE_HEAD.map((head) => (
            <th
              key={head}
              className="cursor-pointer border-y border-blue-gray-100 bg-blue-gray-50/50 p-4 transition-colors hover:bg-blue-gray-50"
            >
              <Typography
                variant="small"
                color="blue-gray"
                className="flex items-center justify-between gap-2 font-normal leading-none opacity-70"
              >
                {head} <ChevronUpDownIcon strokeWidth={2} className="h-4 w-4" />
              </Typography>
            </th>
          ))}
          <th className="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4 transition-colors"></th>
        </tr>
      </thead>
      <tbody>
        {templates.map(({ id, name, domain, createdAt }, index) => {
          const className = classNames('p-4', {
            'border-b border-blue-gray-50': index !== templates.length - 1,
          })
          return (
            <tr key={id}>
              <td className={className}>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="font-normal"
                >
                  {name}
                </Typography>
              </td>
              <td className={className}>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="font-normal"
                >
                  {domain}
                </Typography>
              </td>
              <td className={className}>
                <div className="relative flex w-full">
                  <Input
                    type="text"
                    disabled
                    label="Id"
                    value={id}
                    className="pr-20 cursor-text"
                    containerProps={{ className: 'min-w-0' }}
                  />
                  <IconButton
                    size="sm"
                    color="blue-gray"
                    className="!absolute right-1 top-1 rounded"
                  >
                    <ClipboardText />
                  </IconButton>
                </div>
              </td>
              <td align="right" className={className}>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="font-normal"
                >
                  {createdAt.toLocaleDateString()}
                </Typography>
              </td>
              <td align="right" className={className}>
                <Tooltip content="Editar template">
                  <IconButton variant="text" color="blue-gray">
                    <PencilIcon className="h-4 w-4" />
                  </IconButton>
                </Tooltip>
                <Tooltip content="Remover template">
                  <IconButton variant="text" color="blue-gray">
                    <TrashIcon className="h-4 w-4" />
                  </IconButton>
                </Tooltip>
              </td>
            </tr>
          )
        })}
      </tbody>
    </table>
  )
}
