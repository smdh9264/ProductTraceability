<template>
  <div>
    <template v-for="item in menu">
      <el-menu-item v-if="!hasChildren(item)" 
                    :key="item.id"
                    @click="open(item)"
                    :index="item.path">
        <i class="el-icon-setting"></i>
        <span slot="title">{{item.name}}</span>
      </el-menu-item>
      <el-submenu v-else-if="hasChildren(item)" :key="item.id" :index="item.path">
        <template slot="title">
          <span slot="title"
                :class="{'el-menu--display':collapse && first}">{{item.name}}</span>
        </template>
        <template v-for="(child,index) in item.children" >
          <el-menu-item :key="child.id" v-if="!hasChildren(child)" :index="item.path" @click="open(child)">
            <span slot="title">{{child.name}}</span>
          </el-menu-item>
          <sidebar-item v-else-if="!hasChildren(child)" :key="child.id" :menu="child" >

          </sidebar-item>
        </template>
      </el-submenu>
    </template>

    <!-- <template v-if="hasOneShowingChild(item.children,item) && (!onlyOneChild.children||onlyOneChild.noShowingChildren)&&!item.alwaysShow">
      <app-link v-if="onlyOneChild.meta" :to="resolvePath(onlyOneChild.path)">
        <el-menu-item :index="resolvePath(onlyOneChild.path)" :class="{'submenu-title-noDropdown':!isNest}">
          <item :icon="onlyOneChild.meta.icon||(item.meta&&item.meta.icon)" :title="onlyOneChild.meta.title" />
        </el-menu-item>
      </app-link>
    </template>

    <el-submenu v-else ref="subMenu" :index="resolvePath(item.path)" popper-append-to-body>
      <template slot="title">
        <item v-if="item.meta" :icon="item.meta && item.meta.icon" :title="item.meta.title" />
      </template>
      <sidebar-item
        v-for="child in item.children"
        :key="child.path"
        :is-nest="true"
        :item="child"
        :base-path="resolvePath(child.path)"
        class="nest-menu"
      />
    </el-submenu>  -->
  </div>
</template>

<script>
import path from 'path'
import { isExternal } from '@/utils/validate'
import Item from './Item'
import AppLink from './Link'
import FixiOSBug from './FixiOSBug'

export default {
  name: 'SidebarItem',
  components: { Item, AppLink },
  mixins: [FixiOSBug],
  props: {
    // route object
    menu: {
      type: Array,
      required: true
    },
    isNest: {
      type: Boolean,
      default: false
    },
    basePath: {
      type: String,
      default: ''
    }
  },
  data() {
    this.onlyOneChild = null
    return {}
  },
  created(){

  },
  methods: {
    hasChildren(item){
      return item.children !== undefined
    },
    open(item) {
      this.$router.push({path:item.path})
    }

  }
}
</script>
