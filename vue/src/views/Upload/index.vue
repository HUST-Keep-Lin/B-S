<template>
  <div>
    <el-upload
      ref="uploadposition"
      class="upload-demo"
      drag
      action
      :http-request="uploadPosition"
      :limit="fileLimit"
      :file-list="fileList"
      multiple
    >
      <i class="el-icon-upload" />
      <div class="el-upload__text">上传<b>position</b>文件处,或<em>点击上传</em></div>
      <div slot="tip" class="el-upload__tip">只能上传csv文件,且不超过500kb</div>
    </el-upload>

    <el-upload
      ref="uploadrunning"
      class="upload-demo"
      drag
      action
      :http-request="uploadRunning"
      :limit="fileLimit"
      :file-list="fileList"
      multiple
    >
      <i class="el-icon-upload" />
      <div class="el-upload__text">上传<b>running</b>文件处,，或<em>点击上传</em></div>
      <div slot="tip" class="el-upload__tip">只能上传csv文件,且不超过500kb</div>
    </el-upload>

    <el-upload
      ref="uploadground_truth"
      class="upload-demo"
      drag
      action
      :http-request="uploadGround_truth"
      :limit="fileLimit"
      :file-list="fileList"
      multiple
    >
      <i class="el-icon-upload" />
      <div class="el-upload__text">上传<b>ground_truth</b>文件处,，或<em>点击上传</em></div>
      <div slot="tip" class="el-upload__tip">只能上传csv文件,且不超过500kb</div>
    </el-upload>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      fileList: [],
      fileLimit: 3,
      headers: { 'Content-Type': 'multipart/form-data' }
    }
  },

  methods: {
    uploadPosition(item) {
      // 上传文件的需要formdata类型;所以要转
      const FormDatas = new FormData()
      FormDatas.append('file', item.file)

      axios({
        method: 'post',
        url: '/sys/position/upload',
        headers: this.headers,
        timeout: 80000,
        data: FormDatas
      }).then(res => {
        alert('上传成功')
        console.log('上传成功')
      }).catch(response => {
        alert('上传失败')
        console.log('上传失败')
      })
    },
    uploadRunning(item) {
      // 上传文件的需要formdata类型;所以要转
      const FormDatas = new FormData()
      FormDatas.append('file', item.file)

      axios({
        method: 'post',
        url: '/sys/running/upload',
        headers: this.headers,
        timeout: 80000,
        data: FormDatas
      }).then(res => {
        alert('上传成功')
        console.log('上传成功')
      }).catch(response => {
        alert('上传失败')
        console.log('上传失败')
      })
    },
    uploadGround_truth(item) {
      // 上传文件的需要formdata类型;所以要转
      const FormDatas = new FormData()
      FormDatas.append('file', item.file)

      axios({
        method: 'post',
        url: '/sys/truth/upload',
        headers: this.headers,
        timeout: 80000,
        data: FormDatas
      }).then(res => {
        alert('上传成功')
        console.log('上传成功')
      }).catch(response => {
        alert('上传失败')
        console.log('上传失败')
      })
    }
  }
}

</script>
