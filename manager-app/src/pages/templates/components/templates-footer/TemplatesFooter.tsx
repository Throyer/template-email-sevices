import { Button, Typography } from '@material-tailwind/react'

interface TemplatesFooterProps {
  page: number
  size: number
}

export const TemplatesFooter = ({ page, size }: TemplatesFooterProps) => {
  return (
    <>
      <Typography variant="small" color="blue-gray" className="font-normal">
        Page {page} of {size}
      </Typography>
      <div className="flex gap-2">
        <Button variant="outlined" color="blue-gray" size="sm">
          Previous
        </Button>
        <Button variant="outlined" color="blue-gray" size="sm">
          Next
        </Button>
      </div>
    </>
  )
}
