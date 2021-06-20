import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CategoryTemplate} from '../../common/model/categoryTemplate';
import {Category} from '../../common/model/category';
import {CategoryService} from '../../common/service/category.service';
import {FindFirstLevelCategoriesByCategoryTemplateRequest} from '../../common/request/findFirstLevelCategoriesByCategoryTemplateRequest';
import {FindAllByParentCategoryIdRequest} from '../../common/request/findAllByParentCategoryIdRequest';
import {UtilService} from '../../shared/services/util.service';
import {CategoryTemplateService} from '../../common/service/categoryTemplate.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit, OnDestroy {
  keyword = 'name';
  categoryTemplateUrl: string;
  private sub: any;
  categoryTemplate: CategoryTemplate;
  firstCategory: Category;
  secondCategory: Category;
  thirdCategory: Category ;
  fourthCategory: Category;
  firstCategoryList: Category[] = [];
  secondCategoryList: Category[] = [];
  thirdCategoryList: Category[] = [] ;
  fourthCategoryList: Category[] = [];
  findFirstLevelCategoriesByCategoryTemplateRequest: FindFirstLevelCategoriesByCategoryTemplateRequest = {};
  findAllByParentCategoryIdRequest: FindAllByParentCategoryIdRequest = {};
  editMode = false;
  selectedLevel: number;
  selectedCategory: Category;
  parentCategory: Category;

  constructor(private route: ActivatedRoute,
              private categoryService: CategoryService,
              private util: UtilService,
              private categoryTemplateService: CategoryTemplateService) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.categoryTemplateUrl = params['url'];
    });
    if (localStorage.getItem('categoryTemplate')) {
      this.categoryTemplate = JSON.parse(localStorage.getItem('categoryTemplate'));
      this.findAllFirstLevelByCategoryTemplateId();
    } else {
      this.categoryTemplateService.findByUrl(this.categoryTemplateUrl).subscribe(resp => {
        this.categoryTemplate = resp;
        this.findAllFirstLevelByCategoryTemplateId();
      });
    }

  }
  findAllFirstLevelByCategoryTemplateId() {
    this.findFirstLevelCategoriesByCategoryTemplateRequest.categoryTemplateId = this.categoryTemplate.id;
    this.categoryService.getFirstCategoriesByCategoryTemplateId(this.findFirstLevelCategoriesByCategoryTemplateRequest).subscribe(resp => {
      console.log(resp);
      this.firstCategoryList = resp;
    });
  }
  getFindAllByParentCategory(parentCategoryId) {
    this.categoryService.getFindAllByParentCategory(parentCategoryId).subscribe(resp => {
      console.log(resp);
    });
  }
  selectEvent(item, level) {
    this.parentCategory = this.selectedCategory ;
    this.selectedCategory = item;
    this.findAllByParentCategoryIdRequest.id = item.id;
    this.categoryService.getFindAllByParentCategory(this.findAllByParentCategoryIdRequest).subscribe(resp => {
      if (level === 1) {
        this.secondCategoryList = resp;
      } else if (level === 2) {
        this.thirdCategoryList = resp;
      } else if (level === 3) {
        this.fourthCategoryList = resp;
      }
    });
  }

  onChangeSearch(search: string) {
    // fetch remote data from here
    // And reassign the 'data' which is binded to 'data' property.
  }
  onInputCleared(e) {
    this.parentCategory = this.selectedCategory;
    this.selectedCategory = null;
  }

  onFocused(e) {
    // do something
  }
  ngOnDestroy() {
    localStorage.removeItem('categoryTemplate');
    this.sub.unsubscribe();
  }
  newCategory() {
    this.parentCategory = this.selectedCategory;
    this.selectedCategory = {};
  }
  createCategory() {
    this.selectedCategory.parentCategory = this.selectedCategory;
    this.selectedCategory.categoryTemplate = this.categoryTemplate;
    console.log(this.selectedCategory);
    this.categoryService.createCategory(this.selectedCategory).subscribe(resp => {
      console.log(resp);
    });
  }
  updateCategory() {}
  changeUrl() {
    this.selectedCategory.url = this.util.urlFormatter(this.selectedCategory.name);
  }
}
