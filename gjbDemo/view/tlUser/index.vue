<template>
    <div class="app-container calendar-list-container">
        <div class="filter-container">
            <el-button v-if="tl_user_add" class="filter-item" style="margin-left: 10px;" @click="handleCreate" type="primary" icon="edit">添加
            </el-button>
        </div>
        <el-table :key='tableKey' :data="list" v-loading="listLoading" element-loading-text="给我一点时间" border fit
                  highlight-current-row style="width: 100%">
                        <el-table-column align="center" label="">
                <template scope="scope">
                    <span>{{ scope.row.userId }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="手机号">
                <template scope="scope">
                    <span>{{ scope.row.phone }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="密码">
                <template scope="scope">
                    <span>{{ scope.row.password }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="用户名">
                <template scope="scope">
                    <span>{{ scope.row.nick }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="头像">
                <template scope="scope">
                    <span>{{ scope.row.headPort }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="积分">
                <template scope="scope">
                    <span>{{ scope.row.integory }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="余额(单位分)">
                <template scope="scope">
                    <span>{{ scope.row.balance }}</span>
                </template>
            </el-table-column>
                        <el-table-column align="center" label="等级">
                <template scope="scope">
                    <span>{{ scope.row.grade }}</span>
                </template>
            </el-table-column>
            
            <el-table-column label="操作">
                <template scope="scope">
                    <el-button v-if="tl_user_upd" size="small" type="success"
                               @click="handleUpdate(scope.row)">编辑
                    </el-button>
                    <el-button v-if="tl_user_del" size="mini" type="danger"
                               @click="handleDelete(scope.row)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <div v-show="!listLoading" class="pagination-container">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                           :current-page.sync="listQuery.page"
                           :page-sizes="[10,20,30, 50]" :page-size="listQuery.limit"
                           layout="total, sizes, prev, pager, next, jumper" :total="total">
            </el-pagination>
        </div>
        <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="rules" ref="form" label-width="100px">
                                    <el-form-item label="" prop="username">
                        <el-input v-model="form.userId" placeholder=""></el-input>
                    </el-form-item>
                                    <el-form-item label="手机号" prop="username">
                        <el-input v-model="form.phone" placeholder="手机号"></el-input>
                    </el-form-item>
                                    <el-form-item label="密码" prop="username">
                        <el-input v-model="form.password" placeholder="密码"></el-input>
                    </el-form-item>
                                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="form.nick" placeholder="用户名"></el-input>
                    </el-form-item>
                                    <el-form-item label="头像" prop="username">
                        <el-input v-model="form.headPort" placeholder="头像"></el-input>
                    </el-form-item>
                                    <el-form-item label="积分" prop="username">
                        <el-input v-model="form.integory" placeholder="积分"></el-input>
                    </el-form-item>
                                    <el-form-item label="余额(单位分)" prop="username">
                        <el-input v-model="form.balance" placeholder="余额(单位分)"></el-input>
                    </el-form-item>
                                    <el-form-item label="等级" prop="username">
                        <el-input v-model="form.grade" placeholder="等级"></el-input>
                    </el-form-item>
                            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="cancel('form')">取 消</el-button>
                <el-button v-if="dialogStatus=='create'" type="primary" @click="create('form')">确 定</el-button>
                <el-button v-else type="primary" @click="update('form')">修 改</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import { fetchList, addObj, putObj, delObj } from '@/api/tl_user'
    import waves from '@/directive/waves/index.js' // 水波纹指令
    import { mapGetters } from 'vuex'

    export default {
        name: 'table_tl_user',
        directives: {
            waves
        },
        data() {
            return {
                list: null,
                total: null,
                listLoading: true,
                listQuery: {
                    page: 1,
                    limit: 20
                },
                rules: {
                },
                form: {
                },
                dialogFormVisible: false,
                dialogStatus: '',
                    tl_user_add: false,
                    tl_user_upd: false,
                    tl_user_del: false,
                textMap: {
                    update: '编辑',
                    create: '创建'
                },
                tableKey: 0
            }
        },
        computed: {
            ...mapGetters([
                'permissions'
            ])
        },
        filters: {
            statusFilter(status) {
                const statusMap = {
                    0: '有效',
                    1: '无效'
                }
                return statusMap[status]
            }
        },
        created() {
            this.getList()
            this.tl_user_add = this.permissions['tl_user_add']
            this.tl_user_upd = this.permissions['tl_user_upd']
            this.tl_user_del = this.permissions['tl_user_del']
        },
        methods: {
            getList() {
                this.listLoading = true
                fetchList(this.listQuery).then(response => {
                    this.list = response.data.records
                    this.total = response.data.total
                    this.listLoading = false
                })
            },
            handleSizeChange(val) {
                this.listQuery.limit = val
                this.getList()
            },
            handleCurrentChange(val) {
                this.listQuery.page = val
                this.getList()
            },
            handleDelete(row) {
                delObj(row.id)
                        .then(response => {
                            this.dialogFormVisible = false
                            this.getList()
                            this.$notify({
                                title: '成功',
                                message: '删除成功',
                                type: 'success',
                                duration: 2000
                            })
                        })
            },
            handleCreate() {
                this.dialogStatus = 'create'
                this.dialogFormVisible = true
            },
            create(formName) {
                const set = this.$refs
                        set[formName].validate(valid => {
                    if (valid) {
                        addObj(this.form)
                                .then(() => {
                                    this.dialogFormVisible = false
                                    this.getList()
                                    this.$notify({
                                        title: '成功',
                                        message: '创建成功',
                                        type: 'success',
                                        duration: 2000
                                    })
                                })
                    } else {
                        return false
                    }
                })
            },
            cancel(formName) {
                this.dialogFormVisible = false
                const set = this.$refs
                set[formName].resetFields()
            },
            update(formName) {
                const set = this.$refs
                        set[formName].validate(valid => {
                    if (valid) {
                        this.dialogFormVisible = false
                        this.form.password = undefined
                        putObj(this.form).then(() => {
                            this.dialogFormVisible = false
                            this.getList()
                            this.$notify({
                                title: '成功',
                                message: '修改成功',
                                type: 'success',
                                duration: 2000
                            })
                        })
                    } else {
                        return false
                    }
                })
            },
        }
    }
</script>
